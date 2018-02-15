# Least-Common-Ancestor
## Prerequisite
We need jgrapht. Since this is a Maven project, I have already added pom.xml to fetch dependencies.

## Working
We have a dot file which contains a graph and we need to find all the closest ancestor of two given nodes as command line argument. Since we intend to find all the LCAs of two given nodes, expected graph is a DAG. So you can alter fileName in LeastCommonAncestor class and choose your own dot file. Remember to add only DAG, otherwise it will throw exception.

## Description of Files
LeastCommonAncestor contains a method `allLcas` which uses `DOTImporter` class to parse the dot file as graph and then uses
`findLcaS` from `NaiveLcaFinder`. Since `NaiveLcaFinder` had some some unimplemented functions, I have copied that file and made some changes to `findLcaS` function. Also I had encountered a bug in the implementation (reported [here](https://github.com/jgrapht/jgrapht/issues/490)) of `NaiveLcaFinder` so, I also changed the constructor. to ensure graph is DAG.

I am yet to write test cases, but gives me following output for `Tyrion Cersei`

![tyrioncersei](https://user-images.githubusercontent.com/13489709/36246731-2531425a-1257-11e8-8e1c-6df1e3be6c24.png)

and `Joffrey Tommen`
![joffreytommen](https://user-images.githubusercontent.com/13489709/36246763-4c7c882e-1257-11e8-8072-ec2b21c2d3bf.png)


