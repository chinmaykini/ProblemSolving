# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

A collection of standalone Java algorithm and data structure problems. Each `.java` file is a self-contained solution with its own `main` method — there is no shared build system, framework, or package structure.

## Build & Run

There is no build tool (Maven, Gradle, etc.). Files are compiled and run directly with `javac`/`java`:

```bash
javac KadaneAlgo.java
java KadaneAlgo
```

The Eclipse `.project` and `.classpath` files treat the repo root as both source and output directory. No packages are used — all classes are in the default package.

## Conventions

- One problem per file, named after the algorithm or problem (e.g., `KadaneAlgo.java`, `BoggleSolver.java`).
- Each file contains a single public class matching the filename with a `public static void main` entry point.
- No external dependencies — only the Java standard library.
- Test inputs are hardcoded in `main` methods; there is no test framework.
