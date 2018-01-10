#!/usr/bin/env lumo
(ns backup.core
  (:require lumo.core fs))

(defn copy-file! [src dest]
  (fs/copyFile src dest (fn [error]
    (println "Got an error while copying: " error))))

(defn ^:export -main [& args]
  (let [[src dest] cljs.core/*command-line-args*]
    (println "Source" src "Destination" dest)))

(set! *main-cli-fn* -main)
