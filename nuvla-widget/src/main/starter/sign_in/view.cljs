(ns starter.sign-in.view
  (:require [starter.sign-in.form-validation :as form]
            [clojure.string :as str]
            [starter.sign-in.handler :as handler]
            [form-validator.core :as fv]
            [reagent.core :as r]
            [starter.api.paths :as api-paths]))

(def response-error! (r/atom nil))

(defn FormControl
  [{:keys [error class-name as]
    :or {class-name ""
         as         :input} :as opts} children]
  (let [class-names (-> class-name
                        (str/split #" ")
                        (conj "form-control")
                        (cond-> error (concat ["was-validated" "is-invalid"])))
        opts        (-> opts
                        (dissoc :error :as)
                        (assoc :class-name (str/join " " class-names)))]
    [:<>
     [as opts children]
     (when error
       [:div.invalid-feedback {:style {:padding-left 16}} error])]))

(defn GihubSignIn
  []
  [:form {:action api-paths/USER-URL
          :method :post
          :style  {:display :inline
                   :padding "unset"}}
   [:input {:hidden        true
            :name          "href"
            :default-value api-paths/GITHUB-USER-TEMPLATE-HREF}]
   [:input {:hidden        true
            :name          "redirect-url"
            :default-value api-paths/UI-SIGN-IN-URL}]
   [:button {:style {:background-color :transparent
                     :padding          0
                     :border           0}}
    [:img {:src "/assets/img/icon-github.svg"}]]])

(defn GeantSignIn
  []
  [:form {:action api-paths/USER-URL
          :method :post
          :style  {:display :inline
                   :padding "unset"}}
   [:input {:hidden        true
            :name          "href"
            :default-value api-paths/GEANT-USER-TEMPLATE-HREF}]
   [:button {:style {:background-color :transparent
                     :padding          0
                     :border           0}}
    [:img {:src "/assets/img/icon-flux.svg"}]]])


(defn SignIn
  []
  (let [form!       (fv/init-form form/form-conf)
        error!      (r/atom nil)
        on-change   (partial fv/event->names->value! form!)
        on-blur     (partial fv/event->show-message form!)
        field-error #(fv/?show-message form! %1 form/spec->msg)
        on-submit   #(when true #_(form/form-valid? form!)
                       (handler/add-user
                         (form/form->data form!)
                         error!))
        free-trial? (r/atom false)]
    (fn []
      [:div.shadow.bg-white {:style {:padding "2rem"}}
       [:div.row {:style {:padding-right 32}}
        [:h3 "Sign up"]
        (when @error!
          [:div.alert.alert-danger
           {:style {:margin "12px 16px 16px 16px"}}
           @error!])
        [:div.col-md-6
         [FormControl {:name          :first-name
                       :placeholder   "First name"
                       :auto-complete "firstname"
                       :on-change     on-change
                       :on-blur       on-blur
                       :error         (field-error :first-name)}]]
        [:div.col-md-6
         [FormControl {:name          :last-name
                       :placeholder   "Last name"
                       :auto-complete "lastname"
                       :on-change     on-change
                       :on-blur       on-blur
                       :error         (field-error :last-name)}]]
        [:div.col-md-12
         [FormControl {:name          :email
                       :placeholder   "Email"
                       :auto-complete "email"
                       :on-change     on-change
                       :on-blur       on-blur
                       :error         (field-error :email)}]]
        [:div.col-md-12
         [FormControl {:name        :password
                       :placeholder "Password"
                       :type        "password"
                       :on-change   on-change
                       :on-blur     on-blur
                       :error       (field-error :password)}]]
        [:div.col-md-12
         [:div {:class-name "form-check"}
          [:input {:type       :checkbox
                   :style      {:padding "unset"}
                   :class-name "form-check-input"
                   :on-click   #(reset! free-trial? (.. %1 -target -checked))
                   :id         "flexCheckDefault"}]
          [:label {:class-name "form-check-label"
                   :for        "flexCheckDefault"} "Start your free trial"]
          ]]
        (when @free-trial?
          [:<>
           [:div.col-md-8
            [FormControl {:name        :street-address
                          :placeholder "Street Address"
                          :on-change   on-change
                          :on-blur     on-blur
                          :error       (field-error :street-address)}]]
           [:div.col-md-4
            [FormControl {:name        :postal-code
                          :placeholder "Zip"
                          :on-change   on-change
                          :on-blur     on-blur
                          :error       (field-error :postal-code)}]]
           [:div.col-md-6
            [FormControl {:name        :city
                          :placeholder "City"
                          :on-change   on-change
                          :on-blur     on-blur
                          :error       (field-error :city)}]]
           [:div.col-md-6
            [FormControl
             {:as         :select
              :name       :country
              :class-name "form-select"
              :on-change  (fn [event]
                            (let [value (-> event .-target .-value)
                                  name  (-> event .-target .-name)]
                              (swap! form!
                                     #(assoc-in % [:names->value (keyword name)]
                                                value))
                              (fv/validate-form form!)))
              :on-blur    on-blur
              :error      (field-error :country)}
             (for [{:keys [text key value]} [{:text "Country", :key "none", :value ""} {:text "Afghanistan", :flag "af", :key "af", :value "AF"} {:text "Aland Islands", :flag "ax", :key "ax", :value "AX"} {:text "Albania", :flag "al", :key "al", :value "AL"} {:text "Algeria", :flag "dz", :key "dz", :value "DZ"} {:text "American Samoa", :flag "as", :key "as", :value "AS"} {:text "Andorra", :flag "ad", :key "ad", :value "AD"} {:text "Angola", :flag "ao", :key "ao", :value "AO"} {:text "Anguilla", :flag "ai", :key "ai", :value "AI"} {:text "Antigua", :flag "ag", :key "ag", :value "AG"} {:text "Argentina", :flag "ar", :key "ar", :value "AR"} {:text "Armenia", :flag "am", :key "am", :value "AM"} {:text "Aruba", :flag "aw", :key "aw", :value "AW"} {:text "Australia", :flag "au", :key "au", :value "AU"} {:text "Austria", :flag "at", :key "at", :value "AT"} {:text "Azerbaijan", :flag "az", :key "az", :value "AZ"} {:text "Bahamas", :flag "bs", :key "bs", :value "BS"} {:text "Bahrain", :flag "bh", :key "bh", :value "BH"} {:text "Bangladesh", :flag "bd", :key "bd", :value "BD"} {:text "Barbados", :flag "bb", :key "bb", :value "BB"} {:text "Belarus", :flag "by", :key "by", :value "BY"} {:text "Belgium", :flag "be", :key "be", :value "BE"} {:text "Belize", :flag "bz", :key "bz", :value "BZ"} {:text "Benin", :flag "bj", :key "bj", :value "BJ"} {:text "Bermuda", :flag "bm", :key "bm", :value "BM"} {:text "Bhutan", :flag "bt", :key "bt", :value "BT"} {:text "Bolivia", :flag "bo", :key "bo", :value "BO"} {:text "Bosnia", :flag "ba", :key "ba", :value "BA"} {:text "Botswana", :flag "bw", :key "bw", :value "BW"} {:text "Bouvet Island", :flag "bv", :key "bv", :value "BV"} {:text "Brazil", :flag "br", :key "br", :value "BR"} {:text "British Virgin Islands", :flag "vg", :key "vg", :value "VG"} {:text "Brunei", :flag "bn", :key "bn", :value "BN"} {:text "Bulgaria", :flag "bg", :key "bg", :value "BG"} {:text "Burkina Faso", :flag "bf", :key "bf", :value "BF"} {:text "Burma", :flag "mm", :key "mm", :value "MM"} {:text "Burundi", :flag "bi", :key "bi", :value "BI"} {:text "Caicos Islands", :flag "tc", :key "tc", :value "TC"} {:text "Cambodia", :flag "kh", :key "kh", :value "KH"} {:text "Cameroon", :flag "cm", :key "cm", :value "CM"} {:text "Canada", :flag "ca", :key "ca", :value "CA"} {:text "Cape Verde", :flag "cv", :key "cv", :value "CV"} {:text "Cayman Islands", :flag "ky", :key "ky", :value "KY"} {:text "Central African Republic", :flag "cf", :key "cf", :value "CF"} {:text "Chad", :flag "td", :key "td", :value "TD"} {:text "Chile", :flag "cl", :key "cl", :value "CL"} {:text "China", :flag "cn", :key "cn", :value "CN"} {:text "Christmas Island", :flag "cx", :key "cx", :value "CX"} {:text "Cocos Islands", :flag "cc", :key "cc", :value "CC"} {:text "Colombia", :flag "co", :key "co", :value "CO"} {:text "Comoros", :flag "km", :key "km", :value "KM"} {:text "Congo", :flag "cd", :key "cd", :value "CD"} {:text "Congo Brazzaville", :flag "cg", :key "cg", :value "CG"} {:text "Cook Islands", :flag "ck", :key "ck", :value "CK"} {:text "Costa Rica", :flag "cr", :key "cr", :value "CR"} {:text "Cote Divoire", :flag "ci", :key "ci", :value "CI"} {:text "Croatia", :flag "hr", :key "hr", :value "HR"} {:text "Cuba", :flag "cu", :key "cu", :value "CU"} {:text "Cyprus", :flag "cy", :key "cy", :value "CY"} {:text "Czech Republic", :flag "cz", :key "cz", :value "CZ"} {:text "Denmark", :flag "dk", :key "dk", :value "DK"} {:text "Djibouti", :flag "dj", :key "dj", :value "DJ"} {:text "Dominica", :flag "dm", :key "dm", :value "DM"} {:text "Dominican Republic", :flag "do", :key "do", :value "DO"} {:text "Ecuador", :flag "ec", :key "ec", :value "EC"} {:text "Egypt", :flag "eg", :key "eg", :value "EG"} {:text "El Salvador", :flag "sv", :key "sv", :value "SV"} {:text "Equatorial Guinea", :flag "gq", :key "gq", :value "GQ"} {:text "Eritrea", :flag "er", :key "er", :value "ER"} {:text "Estonia", :flag "ee", :key "ee", :value "EE"} {:text "Ethiopia", :flag "et", :key "et", :value "ET"} {:text "Europeanunion", :flag "eu", :key "eu", :value "EU"} {:text "Falkland Islands", :flag "fk", :key "fk", :value "FK"} {:text "Faroe Islands", :flag "fo", :key "fo", :value "FO"} {:text "Fiji", :flag "fj", :key "fj", :value "FJ"} {:text "Finland", :flag "fi", :key "fi", :value "FI"} {:text "France", :flag "fr", :key "fr", :value "FR"} {:text "French Guiana", :flag "gf", :key "gf", :value "GF"} {:text "French Polynesia", :flag "pf", :key "pf", :value "PF"} {:text "French Territories", :flag "tf", :key "tf", :value "TF"} {:text "Gabon", :flag "ga", :key "ga", :value "GA"} {:text "Gambia", :flag "gm", :key "gm", :value "GM"} {:text "Georgia", :flag "ge", :key "ge", :value "GE"} {:text "Germany", :flag "de", :key "de", :value "DE"} {:text "Ghana", :flag "gh", :key "gh", :value "GH"} {:text "Gibraltar", :flag "gi", :key "gi", :value "GI"} {:text "Greece", :flag "gr", :key "gr", :value "GR"} {:text "Greenland", :flag "gl", :key "gl", :value "GL"} {:text "Grenada", :flag "gd", :key "gd", :value "GD"} {:text "Guadeloupe", :flag "gp", :key "gp", :value "GP"} {:text "Guam", :flag "gu", :key "gu", :value "GU"} {:text "Guatemala", :flag "gt", :key "gt", :value "GT"} {:text "Guinea", :flag "gn", :key "gn", :value "GN"} {:text "Guinea-Bissau", :flag "gw", :key "gw", :value "GW"} {:text "Guyana", :flag "gy", :key "gy", :value "GY"} {:text "Haiti", :flag "ht", :key "ht", :value "HT"} {:text "Heard Island", :flag "hm", :key "hm", :value "HM"} {:text "Honduras", :flag "hn", :key "hn", :value "HN"} {:text "Hong Kong", :flag "hk", :key "hk", :value "HK"} {:text "Hungary", :flag "hu", :key "hu", :value "HU"} {:text "Iceland", :flag "is", :key "is", :value "IS"} {:text "India", :flag "in", :key "in", :value "IN"} {:text "Indian Ocean Territory", :flag "io", :key "io", :value "IO"} {:text "Indonesia", :flag "id", :key "id", :value "ID"} {:text "Iran", :flag "ir", :key "ir", :value "IR"} {:text "Iraq", :flag "iq", :key "iq", :value "IQ"} {:text "Ireland", :flag "ie", :key "ie", :value "IE"} {:text "Israel", :flag "il", :key "il", :value "IL"} {:text "Italy", :flag "it", :key "it", :value "IT"} {:text "Jamaica", :flag "jm", :key "jm", :value "JM"} {:text "Jan Mayen", :flag "sj", :key "sj", :value "SJ"} {:text "Japan", :flag "jp", :key "jp", :value "JP"} {:text "Jordan", :flag "jo", :key "jo", :value "JO"} {:text "Kazakhstan", :flag "kz", :key "kz", :value "KZ"} {:text "Kenya", :flag "ke", :key "ke", :value "KE"} {:text "Kiribati", :flag "ki", :key "ki", :value "KI"} {:text "Kuwait", :flag "kw", :key "kw", :value "KW"} {:text "Kyrgyzstan", :flag "kg", :key "kg", :value "KG"} {:text "Laos", :flag "la", :key "la", :value "LA"} {:text "Latvia", :flag "lv", :key "lv", :value "LV"} {:text "Lebanon", :flag "lb", :key "lb", :value "LB"} {:text "Lesotho", :flag "ls", :key "ls", :value "LS"} {:text "Liberia", :flag "lr", :key "lr", :value "LR"} {:text "Libya", :flag "ly", :key "ly", :value "LY"} {:text "Liechtenstein", :flag "li", :key "li", :value "LI"} {:text "Lithuania", :flag "lt", :key "lt", :value "LT"} {:text "Luxembourg", :flag "lu", :key "lu", :value "LU"} {:text "Macau", :flag "mo", :key "mo", :value "MO"} {:text "Macedonia", :flag "mk", :key "mk", :value "MK"} {:text "Madagascar", :flag "mg", :key "mg", :value "MG"} {:text "Malawi", :flag "mw", :key "mw", :value "MW"} {:text "Malaysia", :flag "my", :key "my", :value "MY"} {:text "Maldives", :flag "mv", :key "mv", :value "MV"} {:text "Mali", :flag "ml", :key "ml", :value "ML"} {:text "Malta", :flag "mt", :key "mt", :value "MT"} {:text "Marshall Islands", :flag "mh", :key "mh", :value "MH"} {:text "Martinique", :flag "mq", :key "mq", :value "MQ"} {:text "Mauritania", :flag "mr", :key "mr", :value "MR"} {:text "Mauritius", :flag "mu", :key "mu", :value "MU"} {:text "Mayotte", :flag "yt", :key "yt", :value "YT"} {:text "Mexico", :flag "mx", :key "mx", :value "MX"} {:text "Micronesia", :flag "fm", :key "fm", :value "FM"} {:text "Moldova", :flag "md", :key "md", :value "MD"} {:text "Monaco", :flag "mc", :key "mc", :value "MC"} {:text "Mongolia", :flag "mn", :key "mn", :value "MN"} {:text "Montenegro", :flag "me", :key "me", :value "ME"} {:text "Montserrat", :flag "ms", :key "ms", :value "MS"} {:text "Morocco", :flag "ma", :key "ma", :value "MA"} {:text "Mozambique", :flag "mz", :key "mz", :value "MZ"} {:text "Namibia", :flag "na", :key "na", :value "NA"} {:text "Nauru", :flag "nr", :key "nr", :value "NR"} {:text "Nepal", :flag "np", :key "np", :value "NP"} {:text "Netherlands", :flag "nl", :key "nl", :value "NL"} {:text "Netherlandsantilles", :flag "an", :key "an", :value "AN"} {:text "New Caledonia", :flag "nc", :key "nc", :value "NC"} {:text "New Guinea", :flag "pg", :key "pg", :value "PG"} {:text "New Zealand", :flag "nz", :key "nz", :value "NZ"} {:text "Nicaragua", :flag "ni", :key "ni", :value "NI"} {:text "Niger", :flag "ne", :key "ne", :value "NE"} {:text "Nigeria", :flag "ng", :key "ng", :value "NG"} {:text "Niue", :flag "nu", :key "nu", :value "NU"} {:text "Norfolk Island", :flag "nf", :key "nf", :value "NF"} {:text "North Korea", :flag "kp", :key "kp", :value "KP"} {:text "Northern Mariana Islands", :flag "mp", :key "mp", :value "MP"} {:text "Norway", :flag "no", :key "no", :value "NO"} {:text "Oman", :flag "om", :key "om", :value "OM"} {:text "Pakistan", :flag "pk", :key "pk", :value "PK"} {:text "Palau", :flag "pw", :key "pw", :value "PW"} {:text "Palestine", :flag "ps", :key "ps", :value "PS"} {:text "Panama", :flag "pa", :key "pa", :value "PA"} {:text "Paraguay", :flag "py", :key "py", :value "PY"} {:text "Peru", :flag "pe", :key "pe", :value "PE"} {:text "Philippines", :flag "ph", :key "ph", :value "PH"} {:text "Pitcairn Islands", :flag "pn", :key "pn", :value "PN"} {:text "Poland", :flag "pl", :key "pl", :value "PL"} {:text "Portugal", :flag "pt", :key "pt", :value "PT"} {:text "Puerto Rico", :flag "pr", :key "pr", :value "PR"} {:text "Qatar", :flag "qa", :key "qa", :value "QA"} {:text "Reunion", :flag "re", :key "re", :value "RE"} {:text "Romania", :flag "ro", :key "ro", :value "RO"} {:text "Russia", :flag "ru", :key "ru", :value "RU"} {:text "Rwanda", :flag "rw", :key "rw", :value "RW"} {:text "Saint Helena", :flag "sh", :key "sh", :value "SH"} {:text "Saint Kitts and Nevis", :flag "kn", :key "kn", :value "KN"} {:text "Saint Lucia", :flag "lc", :key "lc", :value "LC"} {:text "Saint Pierre", :flag "pm", :key "pm", :value "PM"} {:text "Saint Vincent", :flag "vc", :key "vc", :value "VC"} {:text "Samoa", :flag "ws", :key "ws", :value "WS"} {:text "San Marino", :flag "sm", :key "sm", :value "SM"} {:text "Sandwich Islands", :flag "gs", :key "gs", :value "GS"} {:text "Sao Tome", :flag "st", :key "st", :value "ST"} {:text "Saudi Arabia", :flag "sa", :key "sa", :value "SA"} {:text "Scotland", :flag "gb sct", :key "gb sct", :value "GB SCT"} {:text "Senegal", :flag "sn", :key "sn", :value "SN"} {:text "Serbia", :flag "cs", :key "cs", :value "CS"} {:text "Serbia", :flag "rs", :key "rs", :value "RS"} {:text "Seychelles", :flag "sc", :key "sc", :value "SC"} {:text "Sierra Leone", :flag "sl", :key "sl", :value "SL"} {:text "Singapore", :flag "sg", :key "sg", :value "SG"} {:text "Slovakia", :flag "sk", :key "sk", :value "SK"} {:text "Slovenia", :flag "si", :key "si", :value "SI"} {:text "Solomon Islands", :flag "sb", :key "sb", :value "SB"} {:text "Somalia", :flag "so", :key "so", :value "SO"} {:text "South Africa", :flag "za", :key "za", :value "ZA"} {:text "South Korea", :flag "kr", :key "kr", :value "KR"} {:text "Spain", :flag "es", :key "es", :value "ES"} {:text "Sri Lanka", :flag "lk", :key "lk", :value "LK"} {:text "Sudan", :flag "sd", :key "sd", :value "SD"} {:text "Suriname", :flag "sr", :key "sr", :value "SR"} {:text "Swaziland", :flag "sz", :key "sz", :value "SZ"} {:text "Sweden", :flag "se", :key "se", :value "SE"} {:text "Switzerland", :flag "ch", :key "ch", :value "CH"} {:text "Syria", :flag "sy", :key "sy", :value "SY"} {:text "Taiwan", :flag "tw", :key "tw", :value "TW"} {:text "Tajikistan", :flag "tj", :key "tj", :value "TJ"} {:text "Tanzania", :flag "tz", :key "tz", :value "TZ"} {:text "Thailand", :flag "th", :key "th", :value "TH"} {:text "Timorleste", :flag "tl", :key "tl", :value "TL"} {:text "Togo", :flag "tg", :key "tg", :value "TG"} {:text "Tokelau", :flag "tk", :key "tk", :value "TK"} {:text "Tonga", :flag "to", :key "to", :value "TO"} {:text "Trinidad", :flag "tt", :key "tt", :value "TT"} {:text "Tunisia", :flag "tn", :key "tn", :value "TN"} {:text "Turkey", :flag "tr", :key "tr", :value "TR"} {:text "Turkmenistan", :flag "tm", :key "tm", :value "TM"} {:text "Tuvalu", :flag "tv", :key "tv", :value "TV"} {:text "U.A.E.", :flag "ae", :key "ae", :value "AE"} {:text "Uganda", :flag "ug", :key "ug", :value "UG"} {:text "Ukraine", :flag "ua", :key "ua", :value "UA"} {:text "United Kingdom", :flag "gb", :key "gb", :value "GB"} {:text "United States", :flag "us", :key "us", :value "US"} {:text "Uruguay", :flag "uy", :key "uy", :value "UY"} {:text "US Minor Islands", :flag "um", :key "um", :value "UM"} {:text "US Virgin Islands", :flag "vi", :key "vi", :value "VI"} {:text "Uzbekistan", :flag "uz", :key "uz", :value "UZ"} {:text "Vanuatu", :flag "vu", :key "vu", :value "VU"} {:text "Vatican City", :flag "va", :key "va", :value "VA"} {:text "Venezuela", :flag "ve", :key "ve", :value "VE"} {:text "Vietnam", :flag "vn", :key "vn", :value "VN"} {:text "Wales", :flag "gb wls", :key "gb wls", :value "GB WLS"} {:text "Wallis and Futuna", :flag "wf", :key "wf", :value "WF"} {:text "Western Sahara", :flag "eh", :key "eh", :value "EH"} {:text "Yemen", :flag "ye", :key "ye", :value "YE"} {:text "Zambia", :flag "zm", :key "zm", :value "ZM"} {:text "Zimbabwe", :flag "zw", :key "zw", :value "ZW"}]]
               ^{:key key}
               [:option {:value value} text])]]
           [:div.col-md-5
            [FormControl {:name        :coupon
                          :placeholder "Coupon code"
                          :on-change   on-change
                          :on-blur     on-blur
                          :error       (field-error :coupon)}]]])
        [:div.input-group.input-group-submit.col-md-12
         [:button.btn.btn-secondary
          {:type     "button"
           :style    {:margin 16}
           :on-click on-submit}
          "Sign up for Nuvla"]
         [:div.input-group-text {:style {:padding-right 0}}
          [:span {:style {:font-size ".9rem"
                          :color     "#000105"}} "Sign up with"]
          [GihubSignIn]
          [GeantSignIn]]]]
       ])))
