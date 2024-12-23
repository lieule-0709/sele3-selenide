# sele3-selenide

# Output:

- [x] Selenide FW (https://selenide.org/): automation FW, test FW
- [x] Reports: Allure Report
- [x] Test retry: test failed => retry (1, 2) => immediately of after done 
  - Override IRetryAnalyzer and IAnnotationTransformer of TestNG and add listener class
- [x] Parallel/distributed testing
- [x] Cross browsers testing: Chrome, Edge
  - By using in cmd
      - -Dselenide.browser=chrome
      - -Dselenide.browser=edge
      - -Dselenide.browser=firefox
- [ ] Selenium Grid/Shard
- [ ] Test cases: VJ, Agoda, TBD

# User cases:
- [ ] Content testing
- [ ] Multiple languages testing
- [x] Group tests by purposes: regression, smoke/sanity test
      mvn test -Dcucumber.filter.tags='@feature_file_name'
- [ ] Schedule test, send email notification result with summary
- [x] Source control practice: branch => create PR
- [ ] Switch test environment: dev, stg
