basePath = '../';

files = [
  ANGULAR_SCENARIO,
  ANGULAR_SCENARIO_ADAPTER,
  'test/e2e/**/*.js'
];

autoWatch = false;

browsers = ['Chrome'];

singleRun = false;

proxies = {
  '/': 'http://localhost:8000/angular-phonecat'
};

junitReporter = {
  outputFile: 'target/test_out/e2e.xml',
  suite: 'e2e'
};
