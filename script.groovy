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
// def updateVersionsh(){
//   echo "reading version"
//   sh "read ver <<< $(awk -F\":\" '/\"version\":.\"[0-9]\.[0-9]\.[0-9]/ {print ${2}}' package.json | sed 's/,////; s/\"////g')"
//   sh "IFS=\".\" read -a version <<< ${ver}"
//   echo "the package version: $version"

// }
def updateVersion(){
  fields=readJSON file: 'package.json'
  versions= fields['version'].split("\\.")
  major=versions[0]
  minor=versions[1]
  patch=versions[2]
  patch+=patch
  println("version")
  printf("%s, %s, %s",major, minor, patch)
  println("version printed")
  env.IMAGE_NAME="blowman/my-app:"+major +"."+minor+"."+patch
}
def buildImage(){

}
def dockerLogin(){

}
def dockerPush(){

}
return this