(ns app.core
  (:require
   [reagent.core :as r]
   [app.state :as as]
   ))

(defn app-routes []
  )

(defn current-page [app-state]
  [:div "hello world"])

(defn before-load []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))

(defn after-load []
  ;; start is called by init and after code reloading finishes
  ;; this is controlled by the :after-load in the config
  (js/console.log "start")
  (r/render
   [current-page as/app-state]
   (.getElementById js/document "app")))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (app-routes)
  (after-load))
