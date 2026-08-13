class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        maxArea = 0
        

        visited = set()

        


        def searchArea(grid: List[List[int]], row: int, col:int):
            unsearched = deque([(row, col)])
            visited.add((row, col))
            areaSize = 1

            

            while unsearched:
                row, col = unsearched.popleft()

                if row + 1 < len(grid) and grid[row+1][col] == 1 and (row+1, col) not in visited:
                    visited.add((row+1,col))
                    unsearched.append((row+1, col))
                    areaSize += 1
                if row - 1 >= 0 and grid[row - 1][col] == 1 and (row-1, col) not in visited:
                    visited.add((row-1,col))
                    unsearched.append((row-1, col))
                    areaSize += 1
                if col + 1 < len(grid[0]) and grid[row][col+1] == 1 and (row, col+1) not in visited:
                    visited.add((row,col+1))
                    unsearched.append((row,  col+1))
                    areaSize += 1
                if col - 1 >= 0 and grid[row][col-1] == 1 and (row, col-1) not in visited:
                    visited.add((row,col-1))
                    unsearched.append((row, col-1))
                    areaSize += 1

            print(areaSize)
            return max(maxArea, areaSize)


        


        for row in range(len(grid)):
            for col in range(len(grid[row])):
                if grid[row][col] == 1 and (row,col) not in visited:
                    maxArea = searchArea(grid, row, col)
        
        return maxArea