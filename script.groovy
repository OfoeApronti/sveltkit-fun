def buildApp(){
  echo "building the application"
}
def testApp(){
  echo "testing the application"
}
def deployApp(){
  echo "deploying the application"
  echo "execute version: ${params.VERSION}"
}
def updateVersion(){
  echo "reading version"
  sh "read ver <<< $(awk -F\":\" '/\"version\":.\"[0-9]\.[0-9]\.[0-9]/ {print \$2;exit}' package.json | sed 's/,\/\/; s/\"\/\/g')"
  sh "IFS=\".\" read -a version <<< ${ver}"
  echo "the package version: $version"

}
def buildImage(){

}
def dockerLogin(){

}
def dockerPush(){

}
return this