# Companion

`companion` is an Android app project bootstrapped from `companion` and trimmed to keep the
main application, modular architecture, and developer-critical quality gates.

## Scope

Kept in this repository:

- Main Android app module: `:app`
- Core modules under `:core:*`
- Feature modules under `:feature:*`
- Sync and test-support modules required for local tests, instrumentation tests, screenshot tests,
  Hilt test setup, and custom lint
- Build logic, Spotless, Dependency Guard, custom lint, Jacoco, Roborazzi, and GitHub Actions

Removed from the upstream sample:

- `app-nia-catalog`
- `benchmarks`
- Upstream docs and design assets
- Google internal Kokoro CI files

## Build Variants

The app keeps the original flavor model:

- `demo`: uses local/demo data and is the default development target
- `prod`: keeps the production flavor wiring for release builds

Recommended variants:

- `demoDebug` for everyday development
- `demoRelease` for release verification and artifact generation

## Development

Requirements:

- JDK 21 for local Gradle and CI tasks
- Android SDK installed locally
- Android Studio recent stable version is recommended

Useful commands:

```bash
./gradlew spotlessApply
./gradlew spotlessCheck
./gradlew lint
./gradlew testDemoDebugUnitTest
./gradlew connectedDemoDebugAndroidTest
./gradlew dependencyGuard
./gradlew :build-logic:convention:check
./gradlew :app:assembleDemoRelease :app:bundleDemoRelease
```

## Testing And Quality Gates

This repository intentionally keeps the developer-facing quality infrastructure:

- `spotless` for formatting and license headers
- Android `lint` plus the local `:lint` module
- `dependencyGuard` for dependency baseline verification
- `jacoco` coverage wiring
- `roborazzi` screenshot tests
- Hilt/UI/instrumentation test support modules such as `:ui-test-hilt-manifest`,
  `:sync:sync-test`, and `:core:screenshot-testing`

Verified locally in this repo:

```bash
./gradlew spotlessCheck lint testDemoDebugUnitTest
./gradlew :build-logic:convention:check dependencyGuard
```

## CI And Release

GitHub Actions workflows live under `.github/workflows`:

- `Build.yaml`: format, dependency guard, lint, unit tests, screenshot tests, assemble, and
  instrumentation tests
- `Release.yml`: builds `demoRelease` APK/AAB artifacts for tagged releases

## License Header

Source formatting is configured to apply the following header format:

```text
Copyright <year> microboat. All rights reserved.
```
