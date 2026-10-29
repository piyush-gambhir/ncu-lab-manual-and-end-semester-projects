# Security scanning

CodeQL checks the supported source languages and GitHub Actions. Ruff 0.17.3 checks Python and
notebooks without executing examples or requiring provider credentials.

Piyush confirmed revocation of the historical Hugging Face token on 2026-10-29. GitHub secret
alert #1 is resolved as revoked. AAIES Experiment 15 now reads `HF_TOKEN` from the environment;
the exposed value is removed from the current tree, without rewriting public history.

Reviewed exceptions are annotated at individual call sites:

- Game and simulation randomness does not create credentials (`S311`).
- Exercise assertions are not authentication checks (`S101`).
- Frozen Lake loads a Q-table generated locally by that exercise (`S301`). Never load an
  untrusted pickle: deserialization can execute code.
- Blackjack clears the terminal with a fixed platform command, with no user input (`S605`).

These exceptions do not permit the same patterns in authentication or untrusted-input paths.
The OS page-replacement exercise's stray `5` was removed so the security parser can analyze it.
