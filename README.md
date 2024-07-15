## Springboot - Swagger - Scala

### Starting project

- Be sure you have SBT installed in your system (use `sbt --version`), I use version 1.10
- If SBT not installed, I recommend installing it using SDKMAN! (use `sdk version`), script: 5.18.2, native: 0.4.6
- While located in the main folder run `sbt run` to install `build.sbt` dependencies and start the project
- You can check Swagger documentation and interact with the APIS going to `http://localhost:8080/swagger-ui/index.html`

### Testing project

- After checking all steps from previous part, run `sbt test` for running all testing


### Building project

- `sbt assembly` `sbt clean assembly` (work in progress)