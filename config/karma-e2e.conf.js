basePath = '../';

files = [
  ANGULAR_SCENARIO,
  ANGULAR_SCENARIO_ADAPTER,
  'test/e2e/**/*.js'
];

autoWatch = false;

browsers = ['Chrome','Safari'];

singleRun = true;

proxies = {
  '/': 'http://localhost:8080/angular-phonecat/',
  '/angular-phonecat': 'http://localhost:8080/angular-phonecat/',
  '/angular-phonecat/static': 'http://localhost:8080/angular-phonecat/static'
};

urlRoot = '/__karma/';

junitReporter = {
  outputFile: 'target/test_out/e2e.xml',
  suite: 'e2e'
};
