# KMP Algorithm
This is about famous Algorithm for searching pattern that has in text or not. For simple search to find that pattern is in the text or note we already have O(M*N) time complexity to find with M and N is lenght of each string.

The Idea that we will build temporary array that find sub string in pattern that is prefix and suffix
EX: ABCDABC: In this pattern ABC is sub string that is prefix and suffix [ABC]D[ABC].
    So we have array that store the max lenght of sub String is [0,0,0,0,1,2,3]

    We have String is ABCDYABCDABCY and we will use that array to find that pattern is substring in that String we input.

For more understand I will give a link about detail how is work in here: https://www.youtube.com/watch?v=GTJr8OvyEVQ

REQUIRE: ALL OF YOU NEED TO INPUT THE ID OF EXERCISE IN https://leetcode.com/problemset/all/ TO FIND AND READ THE DESCRIPTION OF EXERCISE TO UNDESTAND AND THINKING THE PROBLEM. THANKYOU ><

---RESUP---
