#!/usr/bin/env lumo
(require '[cljs.nodejs :as nodejs])
(def https (nodejs/require "https"))
(def fs (nodejs/require "fs"))

; (def config
;   (-> (.parse js/JSON (.readFileSync fs "config.json"))
;       (js->clj)))

;; https://nodejs.org/api/fs.html
;;fs.copyFile(src, dest[, flags], callback)
(defn copy-file! [src dest]
  (fs.copyFile src dest (fn [error]
                         (println "Got an error when copying: " error))))

; arg 0 = lumo
; arg 1 = nexe.js
; arg 2 = script name
(let [[_ _ _ src dest] (js->clj js/process.argv)]
  (println src dest)
  (comment (copy-file! src dest))) ;; since this is an executable script, we can just invoke our fn REPL-style
