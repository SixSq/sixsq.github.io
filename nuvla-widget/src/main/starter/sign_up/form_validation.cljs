(ns starter.sign-up.form-validation
  (:require
    [cljs.spec.alpha :as s]
    [clojure.string :as str]
    [form-validator.core :as fv]
    [starter.api.paths :as api-paths]))

(defn nonblank-string [s]
  (let [str-s (str s)]
    (when-not (str/blank? str-s)
      str-s)))

(defn acceptable-password?
  [password]
  (and (string? password)
       (>= (count password) 8)
       (re-matches #"^.*[A-Z].*$" password)
       (re-matches #"^.*[a-z].*$" password)
       (re-matches #"^.*[0-9].*$" password)
       (re-matches #"^.*[A-Za-z0-9].*$" password)))

(s/def ::password acceptable-password?)

(s/def ::password-repeat ::password)

(def email-regex #"^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")

(defn email? [s] (re-matches email-regex s))

(s/def ::email (s/and string? email?))

(s/def ::email (s/and string? email?))
(s/def ::password acceptable-password?)
(s/def ::password-repeat nonblank-string)
(s/def ::first-name nonblank-string)
(s/def ::last-name nonblank-string)
(s/def ::street-address nonblank-string)
(s/def ::city nonblank-string)
(s/def ::country nonblank-string)
(s/def ::postal-code nonblank-string)
(s/def ::coupon string?)

(s/def ::user-template-email-password
  (s/keys :req-un [::email
                   ::password
                   ::first-name
                   ::last-name]))

(s/def ::user-template-email-password-full
  (s/keys :req-un [::email
                   ::password
                   ::first-name
                   ::last-name
                   ::street-address
                   ::city
                   ::country
                   ::postal-code]
          :opt-un [::coupon]))


(defn password-repeat-check [form! name]
  (let [password        (get-in @form! [:names->value :password])
        password-repeat (get-in @form! [:names->value name])]
    (when-not (= password password-repeat)
      [:password-repeat :password-not-equal])))


(def form-conf {:form-spec    ::user-template-email-password
                :names->value {:email          ""
                               :password       ""
                               :first-name     ""
                               :last-name      ""
                               :street-address ""
                               :city           ""
                               :country        ""
                               :postal-code    ""}})

(def spec->msg {::email    "Typo? It doesn't look like a valid email."
                ::password "Password must contain at least 8 characters, with one uppercase, one lowercase, one digit and one special character."})

(defn form->data
  [form!]
  (let [{:keys [first-name last-name
                coupon email password] :as form} (:names->value @form!)
        customer (when (= (:form-spec @form!) ::user-template-email-password-full)
                   (cond-> {:fullname      (str first-name " " last-name)
                            :address       (select-keys form [:street-address
                                                              :city
                                                              :country
                                                              :postal-code])
                            :subscription? true}
                           (not (str/blank? coupon)) (assoc :coupon coupon)))]
    {:template
     (cond-> {:href         api-paths/EMAIL-PASSWORD-USER-TEMPLATE-HREF
              :email        email
              :password     password
              :redirect-url (str api-paths/UI-SIGN-IN-URL
                                 "?message="
                                 (js/encodeURI "signup-validation-success"))}
             customer (assoc :customer customer))}))

(defn form-valid?
  [form!]
  (fv/validate-form-and-show? form!))
