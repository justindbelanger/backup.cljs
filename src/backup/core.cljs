(ns backup.core
  (:require lumo.core https fs))

;; https://nodejs.org/api/fs.html
;;fs.copyFile(src, dest[, flags], callback)
(defn copy-file! [src dest]
  (fs/copyFile src dest (fn [error]
                          (println "Got an error when copying: " error))))

(defn ^:export -main [& args]
  ;; Lumo's already trims the args for you and put them in cljs.core/*command-line-args*
  (let [[src dest] cljs.core/*command-line-args*]
    (println "Source" src "Destination" dest)))

(set! *main-cli-fn* -main)
