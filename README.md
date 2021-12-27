# aws-lambda-localstack-example
This is a sample lambda function that uses localstack to run a simple http server.
It is made in Java and uses the AWS SDK for Java with java11.
It returns a json in the following format:
```
{
    "buildTool":"Gradle",
    "cloudTool":"Localstack",
    "container":"Docker",
    "language":"Java",
    "creator":"Victor Mwangi"
}
 ```
Below are steps to run the function locally:
## Step 1:
### Get the following requirements
- [Java >= 11](https://www.java.com/en/download/) 
- [Gradle](https://gradle.org/install/download)
- [Docker](https://www.docker.com/community-edition) and [Docker Compose](https://docs.docker.com/compose/install/)
- [awslocal](https://github.com/localstack/awscli-local).

### Set up the environment
- clone this repository `git clone https://github.com/vikie1/aws-lambda-localstack-example.git`
- cd into the directory `cd aws-lambda-localstack-example`
- start localstack `docker-compose up`
- build the jar file `gradle uberJar` -> This creates a jar file with all dependencies in order to run as a lambda check the `build.gradle` file

### Run the function locally
- Using [awslocal](https://github.com/localstack/awscli-local) run the following command:
```
  awslocal lambda create-function --function-name learningLambdasInlocalstack --runtime java11 --handler org.example.LambdaHandler --region us-east-1 --zip-file fileb://build/libs/aws-lambda-test-1.0-uber.jar --role arn:aws:iam::12345:role/ignoreme
```
- You should see an output similar to the following:
```
{
    "FunctionName": "learningLambdasInlocalstack",
    "FunctionArn": "arn:aws:lambda:us-east-1:000000000000:function:learningLambdasInlocalstack",
    "Runtime": "java11",
    "Role": "arn:aws:iam::12345:role/ignoreme",
    "Handler": "org.example.LambdaHandler",
    "CodeSize": 701143,
    "Description": "",
    "Timeout": 3,
    "LastModified": "2021-12-27T06:53:02.905+0000",
    "CodeSha256": "opQJWm0xSVO5771kVmStISwAjwSZA0NvFhnTI4Ir1Yo=",
    "Version": "$LATEST",
    "VpcConfig": {},
    "TracingConfig": {
        "Mode": "PassThrough"
    },
    "RevisionId": "0374950b-8e7a-41ce-abef-ee8ea868e87c",
    "State": "Active",
    "LastUpdateStatus": "Successful",
    "PackageType": "Zip",
    "Architectures": [
        "x86_64"
    ]
}

```
- You can invoke the function locally by running the following command:
```
awslocal lambda invoke --function-name learningLambdasInlocalstack --invocation-type RequestResponse --no-sign-request --payload '{"SomeValue":"some item"}' ./output.json
```
you should see the following output:
```
{
    "StatusCode": 200,
    "LogResult": "",
    "ExecutedVersion": "$LATEST"
}
```
- You can now check the `output.json` it should look similar to the following:
```
{
    "buildTool":"Gradle",
    "cloudTool":"Localstack",
    "container":"Docker",
    "language":"Java",
    "creator":"Victor Mwangi"
}
 ```