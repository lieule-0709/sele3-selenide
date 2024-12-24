# sele3-selenide

# Output:

- [x] Selenide library (https://selenide.org/) with Cucumber and TestNG
- [x] Reports: Allure Report
- [x] Test retry: test failed => retry (1, 2) => immediately of after done 
  - Override IRetryAnalyzer and IAnnotationTransformer of TestNG and add listener class
  - Change in test.properties file or directly using in command -Dretry={number}
- [x] Parallel/distributed testing
- [x] Cross browsers testing: Chrome, Edge
  - By using in cmd
      - -Dselenide.browser=chrome
      - -Dselenide.browser=edge
      - -Dselenide.browser=firefox
- [ ] Selenium Grid/Shard
- [ ] Test cases: VJ, Agoda, TBD
- [ ] Schedule test, send email notification result with summary

# User cases:
- [ ] Content testing
- [ ] Multiple languages testing
- [x] Group tests by purposes: regression, smoke/sanity test
  - Add tag in features file/ in front of scenarios, scenario outlines
  - Run file/ scenarios which selected tags using command line: mvn test -Dcucumber.filter.tags='@feature_file_name'
- [x] Source control practice: branch => create PR
- [ ] Switch test environment: dev, stg
- [ ] Compare with another FW e.g. Playwright
- [ ] Wrap custom controls
