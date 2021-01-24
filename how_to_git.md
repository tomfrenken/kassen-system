In dieser Datei sind die Grundbefehle die Ihr für euren Git workflow braucht.

git add "your.file" | name von der sache die ihr commit wollt
git commit -m "commit message" | commit message mit dem format, "verb, änderung" z.B. "add admin view" oder "add new test case"
git push | pushed euer änderung auf den branch auf dem ihr grade seid
git pull | pulled änderungen vom remote reposistory (e.G. main)
git pull origin main | pulled mögliche änderungen vom remote repository und merged sie in dein lokales repository
----
git checkout -b "neuer branch" | erstellt neuen branch
git checkout "branch" | switched zu einem existierenden branch
git branch -d "branch name" | löscht einen branch lokal
----
Pull requests & merges über github.com