# Short Video Example
https://streamable.com/6wfsus

# Execution

The Closest Points program is ran using the following command on the command line. It is built on Java version 17.0.2 and requires a similar installation to run:

```
java -jar c:\pathtojarfile.jar
```

When already in the same folder, this is:

```
java -jar closestPoints.jar
```

with both the closestPoints.jar file and points.txt file in the same folder

# Basics
This program takes 100 points from a file and finds the distance between the two closest points. It compares the runtime for a brute force algorithm and dynamic algorithm attempting to do this. The brute force solution runs in O(n^2) time while the dynamic algorithm seems to take O(nlogn*logn).

# Details

The program takes 100 points from a file generated by CreatePoints.java, sorted by x-intercept. It runs a brute force algorithm comparing each point to each other points and finding the minimum distance of each one.
In addition, it runs a dynamic algorithm which recursively splits the points into half until an array only has 3 or fewer points in it. It then runs the brute force algorithm on each of these three points and returns the result. Whenever a result is received, it is compared to other results and the minimum distance is taken. In addition, each branch also computes the middle of its points. A horizontal distance from the middle equal to the current minimum is taken and all points lying within are added to a separate array. They are then sorted by y-intercept and their distances from each other are found. Each point in the strip is compared to a maximum of only 7 points after it, making this part very efficient O(n) even though it looks like it would be O(n^2).

# Extra Details
CreatePoints.java generates a set number of points that the user may select. By default this value is 100 but can be changed to any integer. It always generates the same x-values from the negative half of the selected amount to the positive half. Y-values are randomly generated. This method of point generation ensures that the points are sorted by x-intercept since I encountered difficulties sorting by 2-types of intercepts. To compensate for this, an additional pointless sort is made in the dynamic solution in order to add a similar amount of runtime.

# Difficulties
I could not figure out how to sort by both x-intercept and y-intercept at seperate times. As a result, I built my own Points class and created a compareTo method that would make it sort by y-intercept. Then I ensured that the already provided 100 points were sorted by x-intercept. As a result, this program cannot actually run properly given a random file. In addition, I had to add an additional sort to simulated the wasted time in the dynamic algorithm. With more experience, I would be able to avoid this issue.
