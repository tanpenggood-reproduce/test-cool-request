# Test Cool Request

[复现 cool-request issue#115](https://github.com/houxinlin/cool-request/issues/115)

## Development Environment

- JDK 1.8
- Maven 3.6.0

## Reproduce Step

1. Run `com.example.demo.Application`
2. `curl -X DELETE --url "http://localhost:7777/user/deleteByLogic/2"`