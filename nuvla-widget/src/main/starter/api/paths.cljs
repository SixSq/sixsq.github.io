(ns starter.api.paths
  (:require [clojure.string :as str]))

(def NUVLA_URL "https://sixsqo.localhost")

(def SEPARATOR "/")

(def SERVICE_CONTEXT "api")

(def UI-CONTEXT "ui")

(defn join-url
  [coll]
  (str/join SEPARATOR coll))

(def CLOUD-ENTRY-POINT "cloud-entry-point")

(def USER "user")

(def USER-TEMPLATE "user-template")

(def EMAIL-PASSWORD-USER-TEMPLATE-HREF (join-url [USER-TEMPLATE "email-password"]))

(def GITHUB-USER-TEMPLATE-HREF (join-url [USER-TEMPLATE "nuvla"]))

(def GEANT-USER-TEMPLATE-HREF (join-url [USER-TEMPLATE "geant"]))

(def SIGN-IN "sign-in")

(defn build-api-path
  [resource-name]
  (join-url [SERVICE_CONTEXT resource-name]))

(defn build-ui-path
  [resource-name]
  (join-url [UI-CONTEXT resource-name]))

(defn build-api-url
  [resource-name]
  (join-url [NUVLA_URL (build-api-path resource-name)]))

(defn build-ui-url
  [page]
  (join-url ["https://nuvla.io" #_NUVLA_URL (build-ui-path page)]))

(def CLOUD-ENTRY-POINT-URL (build-api-url CLOUD-ENTRY-POINT))

(def USER-URL (build-api-url USER))

(def UI-SIGN-IN-URL (build-ui-url SIGN-IN))
