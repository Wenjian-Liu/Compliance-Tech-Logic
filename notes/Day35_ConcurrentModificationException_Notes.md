# Day35 — 2026.01.01

## Topic
ConcurrentModificationException & Collection Traversal

## What I Learned
- Understood why ConcurrentModificationException occurs (fail-fast mechanism)
- Clarified differences between Iterator, enhanced for-loop and Lambda forEach
- Learned correct removal pattern using Iterator.remove()

## Key Takeaways
- Structural modification during iteration triggers fail-fast
- enhanced for and forEach are iterator-based
- Only Iterator.remove() is safe during traversal
