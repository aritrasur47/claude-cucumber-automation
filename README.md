# AI-Driven Cucumber Test

BDD test automation framework using Cucumber, Selenium WebDriver, and TestNG.

> 🤖 **Built with [Claude Code](https://claude.com/claude-code)** — this project's cross-browser WebDriver support, documentation, and repo setup were developed using Claude Code.

## Prerequisites

- Java 21
- Maven
- One of: Google Chrome, Mozilla Firefox, Safari (macOS), or Microsoft Edge

## Setup

```bash
git clone https://github.com/aritrasur47/ai-driven-cucumber-test.git
cd ai-driven-cucumber-test
mvn compile
```

## Running Tests

```bash
mvn test -Dtest=TestNGTestRunner
```

Reports are generated under `target/` (ExtentReports HTML, TestNG, and Allure results).

## Browser Configuration

The browser is selected via `src/test/resources/global.properties`:

```properties
browser=chrome
QAUrl=https://rahulshettyacademy.com/seleniumPractise/#/
```

Supported values for `browser` (case-insensitive): `chrome`, `firefox`, `safari`, `edge`.

Driver setup is handled by Selenium Manager automatically for Chrome, Firefox, and Edge — no manual driver downloads needed.

### Safari

Safari requires one-time setup before it can be controlled via WebDriver:

1. Open Safari → **Safari menu → Settings → Advanced** → enable **"Show features for web developers"**.
2. Open the **Develop** menu (now visible in the menu bar) → enable **"Allow Remote Automation"**.
3. Run once in a terminal: `sudo safaridriver --enable`

### Edge

Requires Microsoft Edge to be installed on the machine running the tests.
