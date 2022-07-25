#updates the website with README.md file and a fresh typechef.jar file

#checkout fresh (if needed)
mkdir pages
cd pages || exit
git clone -s -b gh-pages .. TypeChef
cd TypeChef || exit
git checkout gh-pages -f
git reset --hard

#deploy
cd ../..
cp README.md pages/TypeChef/_includes/README.md
if [ "$1" = "--mkjar" ]
then sbt assembly; cp TypeChef-*.jar pages/TypeChef/deploy
else echo not updating .jar file. call with --mkjar parameter to generate .jar file
fi

#update parameter documentation
sbt mkrun
./typechef.sh --help > Parameter.txt
git commit -m "update parameter list with genpages.sh" Parameter.txt

cd pages/TypeChef || exit

#commit
git add *
git commit -a -m "update website with genpages.sh"
git push origin gh-pages

#cleanup
#cd ../..
#rm -r -f pages

