(ns starter.sign-up.handler
  (:require
    [starter.api.helpers :as api-helpers]
    [starter.api.paths :as api-paths]))

(defn add-user
  [data error!]
  (api-helpers/add
    :user
    data
    #()
    :on-error #(let [msg (or (get (->> %
                                       ex-data
                                       :body
                                       (.parse js/JSON)
                                       js->clj)
                                  "message")
                             "An error occured!")]
                 (reset! error! msg))))

