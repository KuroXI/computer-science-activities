<h1>Crime Occurrences</h1>
<h3>by CodeChum Admin<h3>

Detective! You're finally here.

We've been trying to triangulate a bunch of crimes around the city but we need your expertise. What we have here are clusters of numbers, each number representing the severity of a crime. You're going to have to find the crime that occurs the most in the cluster, and if multiple crimes have the same number of occurrences, then you're going to have to pick the most severe among them.

Here. Take the matrix that contains the data.

Note: The most "severe" is the one that occurred the most and has a larger value.

<details>
    <summary>Test 1</summary>
    
    Enter the number of rows: 3
    Enter the number of columns: 3
    1 2 3
    1 2 3
    3 3 3
    Most severe crime = 3
</details>
<details>
    <summary>Test 2</summary>
    
    Enter the number of rows: 5
    Enter the number of columns: 5
    20 34 52 34 34
    20 20 52 1 2
    3 4 5 20 34 2
    2 2 1 75 33
    100 99 85 23 6
    Most severe crime = 34
</details>
<details>
    <summary>Test 3</summary>
    
    Enter the number of rows: 2
    Enter the number of columns: 2
    1 1
    2 3
    Most severe crime = 1
</details>
<details>
    <summary>Test 4</summary>
    
    Enter the number of rows: 2
    Enter the number of columns: 3
    5 10 15
    20 10 13
    Most severe crime = 10
</details>
<details>
    <summary>Test 5</summary>
    
    Enter the number of rows: 1
    Enter the number of columns: 1
    100
    Most severe crime = 100
</details>
<details>
    <summary>Test 6</summary>
    
    Enter the number of rows: 7
    Enter the number of columns: 7
    1 2 3 4 5 6 7
    8 9 1 2 3 4 5
    6 7 8 9 1 2 3
    4 5 6 7 8 9 1
    2 3 4 5 6 7 8
    9 1 2 3 4 5 6
    7 8 9 1 2 3 4
    Most severe crime = 4
</details>
<details>
    <summary>Test 7</summary>
    
    Enter the number of rows: 1
    Enter the number of columns: 2
    5 5
    Most severe crime = 5
</details>
<details>
    <summary>Test 8</summary>
    
    Enter the number of rows: 10
    Enter the number of columns: 10
    100 100 100 100 100 100 100 100 100 100
    99 99 99 99 99 99 99 99 99 99
    98 98 98 98 98 98 98 98 98 98
    97 97 97 97 97 97 97 97 97 97
    96 96 96 96 96 96 96 96 96 96
    95 95 95 95 95 95 95 95 95 95
    94 94 94 94 94 94 94 94 94 94
    93 93 93 93 93 93 93 93 93 93
    92 92 92 92 92 92 92 92 92 92
    91 91 91 91 91 91 91 91 91 91
    Most severe crime = 100
</details>