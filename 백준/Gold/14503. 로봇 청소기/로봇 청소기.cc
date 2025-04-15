//
// Created by 김규민 on 3/6/24.
//
#include <iostream>
#include <cstring>

using namespace std;

int main() {
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    bool map[51][51];
    bool clean[51][51];
    int n, m;
    int curx, cury;
    int status;

    memset(map, false, sizeof(map));
    memset(clean, false, sizeof(clean));
    cin >> n >> m;
    cin >> curx >> cury >> status;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            int a; cin >> a;
            if (a == 1)
                map[i][j] = true;
        }
    }
    int cnt = 0;
    while (true) {
        // 조건 1번
        if (!clean[curx][cury]) {
            clean[curx][cury] = true;
            cnt++;
            continue;
        }

        bool continue_flag = false;
        // 주변 4칸 청소할 수 있는지 검토
        for (int i = 0; i < 4; ++i) {
            if ( curx + dx[i] <= 0 || curx + dx[i] >= n || cury + dy[i] <= 0 || cury + dy[i] >= m)
                continue;
            if (!clean[curx + dx[i]][cury + dy[i]] && map[curx + dx[i]][cury + dy[i]] != true) {
                continue_flag = true;
                break;
            }
        }

        // 청소되지 않은 빈칸이 있는 경우
        if (continue_flag) {
            for (int i = 0; i < 4; ++i) {
                // 90도씩 회전
                status = (status - 1 + 4) % 4;
                // bound 넘어버림
                if (curx + dx[status] <= 0 || curx + dx[status] >= n || cury + dy[status] <= 0 || cury + dy[status] >= m)
                    continue;
                // 벽이 아니면서 청소할 수 있는지 검사
                // 청소할 수 있으면 좌표를 바꿔버림
                if (!clean[curx + dx[status]][cury + dy[status]] &&
                    map[curx + dx[status]][cury + dy[status]] != true) {
                    curx += dx[status];
                    cury += dy[status];
                    break;
                }
            }
        }
        // 청소되지 않은 빈칸이 없는 경우
        else {
            // 뒤로갈 때 범위 넘어가는지 검사
            if (curx - dx[status] <= 0 || curx - dx[status] >= n || cury - dy[status] <= 0 || cury - dy[status] >= m)
                break;
            // 뒤칸이 벽인지 검사
            if (map[curx - dx[status]][cury - dy[status]] == true) {
                break;
            }
            // 모든 조건 통과해서 후진
            else {
                curx -= dx[status];
                cury -= dy[status];
            }
        }
    }
    cout << cnt << endl;
}