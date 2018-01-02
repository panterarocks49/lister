(ns devcards.core_card
  (:require-macros
   [devcards.core :as dc :refer [defcard]])
  (:require
   [reagent.core :as r]
   [devcards.core :as dc]))

(defcard test-card
  (r/as-element
   [:div "test!"]))

(defn ^:export init []
  (dc/start-devcard-ui!))

