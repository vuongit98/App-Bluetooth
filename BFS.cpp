#include<iostream>
using namespace std ;
#define MAX 10
struct ToaDo{
    int x , y ;
};
int MAP[MAX][MAX] ={{0,0,1,0,0,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,0},
                    {0,1,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0}};
int visited[105][105];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
ToaDo Queue[10001];
ToaDo Path[1001];
int index = 0;
ToaDo TruyVet[101][101] ;
void GoDir(ToaDo Path[])
{
    for(int i =index - 1 ; i >= 0 ; i-- ) {
        cout << Path[i].x <<" "<< Path[i].y << endl;
    }
}
void bfs(int fromX, int fromY, int toX , int toY)
{
    for(int i = 0 ; i <= 1001 ; i++) {
        Path[i].x = 0 ;
        Path[i].y = 0 ;
    }
    for(int i =0 ; i <= MAX ; i++) {
        for(int j = 0 ; j <= MAX ; j++)
        {
            visited[i][j] = 0;
        }
    }
    int first =0, last = 0 ;
    Queue[first].x = fromX ;
    Queue[first].y = fromY ;
    visited[fromX][fromY] = 1 ;
    ToaDo temp ;
    temp.x = -1 ;
    temp.y = -1 ;
    TruyVet[fromX][fromY] = temp ;
    first++;
    while(first != last)
    {
        int tempx = Queue[last].x ;
        int tempy = Queue[last++].y ;
        //if(tempx == toX && tempy == toY) break ;
        for(int i = 0 ; i < 4 ; i++)
        {
            int tx = tempx + dx[i] ;
            int ty = tempy + dy[i] ;
            if(tx >= 0 && tx < MAX &&ty >= 0 && ty < MAX && visited[tx][ty] == 0 && MAP[tx][ty] == 0 )
            {
                visited[tx][ty] = visited[tempx][tempy] + 1 ;
                Queue[first].x = tx ;
                Queue[first].y = ty ;
                first++;
                ToaDo temp ;
                temp.x = tempx ;
                temp.y = tempy ;
                TruyVet[tx][ty] = temp;

            }
        }
    }
    index =0 ;
    while(TruyVet[toX][toY].x != -1 || TruyVet[toX][toY].y  != -1)  {
        Path[index].x = toX ;
        Path[index].y = toY ;
        index++;
        int x= TruyVet[toX][toY].x ;
        int y= TruyVet[toX][toY].y ;
        toX = x ;
        toY = y ;
    }
    Path[index].x = fromX ;
    Path[index].y = fromY ;
}
int main()
{
 bfs(0,0,3,3);
 GoDir(Path);
}
