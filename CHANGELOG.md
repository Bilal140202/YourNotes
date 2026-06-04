# Changelog

All notable changes to YourNotes will be documented in this file.

## [1.2.0] - 2025-06-04

### Fixed
- Fixed Room database migration crash on fresh installs by adding `fallbackToDestructiveMigration(true)`
- Fixed Reminders crash caused by `NavBackStack.pop()` emptying the navigation back stack
- Optimized splash screen with proper Material 3 theme colors

### Changed
- Updated splash screen implementation with correct window background colors

---

## [1.1.1] - 2025-06-03

### Fixed
- Fixed navigation drawer crash
- Fixed title display bug on note detail screen
- Fixed splash screen color mismatch

### Added
- New app icon (purple YourNotes branding)
- Animated empty state on homepage using Lottie
- Purple-themed splash screen

---

## [1.1.0] - 2025-06-02

### Changed
- Complete visual reskin with purple Material 3 theme
- Primary color: #6750A4 with dynamic color disabled for consistent branding
- Outfit font family for a modern, clean look
- New navigation bar styling with M3 components

### Added
- Lottie animation for empty screen states

---

## [1.0.0] - 2025-06-01

### Added
- Initial release of YourNotes
- Forked from Play NotePad with complete rebrand
- Package renamed to `com.yournote.notepad`
- All build-logic convention plugins updated
- Updated app name, icons, and resources
- Material 3 theming
- Note creation, editing, and management
- Checklists, labels, reminders, and search
- Drawing, audio recording, and photo attachments
- Lazy mode for auto-scrolling
- Offline support
