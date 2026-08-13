class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        result = 0
        visited = set()

        #bfs
        def trackIsland(grid: List[List[str]], row, col):
            unsearched = deque([(row, col)])

            while unsearched:
                row, col = unsearched.popleft()

                if row + 1 < len(grid) and grid[row+1][col] == "1" and (row+1, col) not in visited:
                    visited.add((row+1,col))
                    unsearched.append((row+1, col))
                if row - 1 >= 0 and grid[row - 1][col] == "1" and (row-1, col) not in visited:
                    visited.add((row-1,col))
                    unsearched.append((row-1, col))
                if col + 1 < len(grid[0]) and grid[row][col+1] == "1" and (row, col+1) not in visited:
                    visited.add((row,col+1))
                    unsearched.append((row,  col+1))
                if col - 1 >= 0 and grid[row][col-1] == "1" and (row, col-1) not in visited:
                    visited.add((row,col-1))
                    unsearched.append((row, col-1))



        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == "1" and (row, col) not in visited:
                    trackIsland( grid, row, col)
                    print("island found")
                    result = result + 1
        return result