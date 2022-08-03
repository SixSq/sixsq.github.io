(ns starter.api.helpers
  (:require-macros
    [cljs.core.async.macros :refer [go]])
  (:require
    [cljs.core.async :refer [<!]]
    [sixsq.nuvla.client.api :as api]
    [sixsq.nuvla.client.async :as async-client]
    [starter.api.paths :as api-paths]))




(def CLIENT (async-client/instance api-paths/CLOUD-ENTRY-POINT-URL))

(defn api-call-error-check
  [api-call on-success on-error]
  (go
    (let [response (<! (api-call))]
      (if (instance? js/Error response)
        (on-error response)
        (on-success response)))))

(defn add
  [collection data on-success & {:keys [on-error]}]
  (let [api-call #(api/add CLIENT collection data)]
    (api-call-error-check api-call on-success (or on-error identity))))
