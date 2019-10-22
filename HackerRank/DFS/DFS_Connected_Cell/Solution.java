//https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs

//All correct

import java.util.ArrayList;
import java.util.Stack;

public class DFS1 {
    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
        DFS1 obj = new DFS1();

        System.out.println(obj.maxReg(grid));
    }

    class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int maxReg(int[][] grid){
        int max = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && visited[i][j]!=1){
                    max = Math.max(max, DFS(i,j,grid,visited));
                }
            }
        }
        return max;
    }

    int DFS(int si,int sj,int[][] grid, int[][] visited){
        Node node = new Node(si,sj);

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        visited[si][sj] = 1;
        int count = 0;
        while(!stack.isEmpty()){
            Node node1 = stack.pop();
            count++;
            ArrayList<Node> children = getChildren(node1, grid, visited);
            printChildren(node1,children);
            for(Node child: children){
                int x = child.x;
                int y = child.y;
                if(visited[x][y] != 1){
                    visited[x][y] = 1;
                    stack.push(child);
                }
            }
        }
        return count;
    }

    void printChildren(Node node, ArrayList<Node> children){
        System.out.println("Node - "+node.x+","+node.y+"\nChildren - ");
        for(Node n:children){
            System.out.println("C - "+n.x+","+n.y);
        }
    }
    ArrayList<Node> getChildren(Node node, int[][] grid, int[][] visited){
        int x = node.x;
        int y = node.y;
        ArrayList<Node> children = new ArrayList<>();

        int n = grid.length;
        int m = grid[0].length;


        //top
        if(x>0){
            if(grid[x-1][y] == 1) {
                Node child = new Node(x - 1, y);
                children.add(child);
            }
        }

        //bottom
        if(x<n-1){
            if(grid[x+1][y] == 1) {
                Node child = new Node(x + 1, y);
                children.add(child);
            }
        }


        //left
        if(y>0){
            if(grid[x][y-1] == 1) {
                Node child = new Node(x, y - 1);
                children.add(child);
            }
        }

        //right
        if(y<m-1){
            if(grid[x][y+1] == 1) {
                Node child = new Node(x, y + 1);
                children.add(child);
            }
        }


        //top-left
        if(x>0 && y>0){
            if(grid[x-1][y-1] == 1) {
                Node child = new Node(x - 1, y - 1);
                children.add(child);
            }
        }

        //top-right
        if(x>0 && y<m-1){
            if(grid[x-1][y+1] == 1) {
                Node child = new Node(x - 1, y + 1);
                children.add(child);
            }
        }

        //bottom-left
        if(x<n-1 && y>0){
            if(grid[x+1][y-1] == 1) {
                Node child = new Node(x + 1, y - 1);
                children.add(child);
            }
        }

        //bottom-right
        if(x<n-1 && y<m-1){
            if(grid[x+1][y+1] == 1) {
                Node child = new Node(x + 1, y + 1);
                children.add(child);
            }
        }

        return children;
    }
}

