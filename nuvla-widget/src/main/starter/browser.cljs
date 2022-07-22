(ns starter.browser
  (:require
    [reagent.core :as r]
    ["react-dom" :as react-dom]
    [starter.sign-in.view :as sign-in-view]
    [form-validator.core :as fv]))

(defn App []
  [sign-in-view/SignIn])

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (js/console.log "start")
  (let [app-node (.getElementById js/document "nuvla-app")]
    (react-dom/render (r/as-element [App]) app-node)))

(defn init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (swap! fv/conf #(merge % {:atom r/atom}))
  (start))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))
