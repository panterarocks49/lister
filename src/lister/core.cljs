(ns lister.core
  (:require
   [reagent.core :as reagent]
   [lister.state :as state]
   [lister.routes :as routes]
   [lister.ipfs :as ipfs]
   [devcards.core_card :as cards]))


(defn home [app-state]
  [:div "home"])


(defmulti current-page (fn [app-state] (:page @app-state)))
(defmethod current-page :home [app-state] home)
;; (defmethod current-page :devcards [app-state] devcards)
(defmethod current-page :default [app-state] (fn [_]))


(defn before-load []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))


(defn after-load []
  ;; start is called by init and after code reloading finishes
  ;; this is controlled by the :after-load in the config
  (js/console.log "start")
  (reagent/render
   [current-page state/app-state]
   (.getElementById js/document "app")))


(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (js/console.log js/window)
  ;; (ipfs/init! state/app-state)
  (routes/app-routes state/app-state)
  (after-load))
