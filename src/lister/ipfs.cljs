(ns lister.ipfs)


(def ipfs-options
  (clj->js
   {:EXPERIMENTAL
    {:pubsub true}}))


(defn init [app-state]
  (let [
        ipfs (new js/Ipfs ipfs-options)]
    (.on ipfs "error" (fn [e] (js/console.log e)))
    (.on ipfs "ready"
         (fn []
           (let [orbit-db (new js/OrbitDB ipfs)
                 access (clj->js
                         {:write ["*"]})
                 db (.keyvalue orbit-db "first-db" access)]
             ;; (js/console.log orbit-db)
             ;; (js/console.log db)
             true
             )))))
