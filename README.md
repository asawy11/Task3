# SER316 - Git Assignment Task 2

## Branch structure
- main: stable release branch
- dev: integration branch for completed features
- feature1: quit game feature + feedback improvements
- feature2: max attempts + game over logic
- feature3: hint feature (work in progress)
- hotfix: fix randomInt max value bug
- documentation: README and workflow notes

## Learning Summary – Git Assignment Task 2

 # Merge vs Rebase vs Squash vs Cherry-pick

**Merge**
- Combines branches while preserving full history
- May introduce merge commits
- Useful when history context matters

**Rebase**
- Rewrites commit history onto another branch
- Creates a cleaner, linear history
- Best used on local feature branches

**Squash**
- Combines multiple commits into one
- Cleans up messy development history
- Ideal before merging feature branches into dev

**Cherry-pick**
- Applies a single commit to another branch
- Commonly used for hotfixes
- Allows fixing main without merging all dev changes

### Observations from This Project
- feature1 was merged normally and required conflict resolution
- feature2 was rebased and then merged, resulting in cleaner history
- feature3 was squashed into a single commit before merging, producing the cleanest history

### When to Use Each Strategy
- Merge: collaborative branches where history matters
- Rebase: cleaning local feature branches
- Squash: finalizing long or messy feature work
- Cherry-pick: urgent fixes that must go to main

