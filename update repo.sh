echo "Write a commit message"
read "msg"
git add "*.*"
git commit -m"$msg"
echo "Press enter to exit"
read "keyb"
