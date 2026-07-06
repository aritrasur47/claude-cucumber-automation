Add this placeholder to your GitHub profile repository README (the repo named exactly as your username) where you want the status to appear:

```md
## Daily Status
<!--WORK_STATUS-->
```

When the workflow runs it will replace `<!--WORK_STATUS-->` with a line like:

**Today:** 🟩 Worked on cucumberproject (2026-06-30)

The placeholder is preserved so the workflow can update it repeatedly.