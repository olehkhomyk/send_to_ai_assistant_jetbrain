# Changelog

## 1.1.0

- Broadened compatibility to all JetBrains IDEs that have the AI Assistant plugin installed (IntelliJ IDEA Community/Ultimate, PyCharm, WebStorm, PhpStorm, GoLand, RubyMine, CLion, Rider, RustRover, DataGrip, Android Studio).
- Switched build target from WebStorm SDK to IntelliJ IDEA Community SDK — the universal base for all JetBrains IDEs.
- Removed unnecessary JavaScript plugin dependency that caused AI Assistant to be disabled after IDE restart.

## 1.0.0

- Initial public release.
- Added an editor action and shortcut to insert selected code into JetBrains AI Assistant.
- Added file name and line range context to the generated prompt.
