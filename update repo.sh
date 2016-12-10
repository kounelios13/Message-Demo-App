echo "Write a commit message"
read "msg"
git add "*.*"
git commit -m"$msg"
git push
echo "Press enter to exit"
read "keyb"
