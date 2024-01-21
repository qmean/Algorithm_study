#include <iostream>

using namespace std;

int N;
double map[51];

int cansee(int building);

void init() {
    cin >> N;
    int tmp;
    for (int i = 0; i < N; ++i) {
        cin >> tmp;
        map[i+1] = tmp;
    }
}

void solve() {
    int max = 0;
    for (int i = 1; i <= N; ++i) {
        int a = cansee(i);
        if (a > max) {
            max = a;
        }
    }
    cout << max << endl;
}

int cansee(int building) {
    int cnt = 0;
    for (int i = 1; i <= building - 1; ++i) {
        double incline;
        double a = (map[building] - map[i]);
        double b = (building - i);
        incline = a / b;
        bool see = true;
        for (int j = i + 1; j <= building - 1; ++j) {
            if ((map[i] + (incline * (j - i))) <= map[j]) {
                see = false;
                break;
            }
        }
        if (see)
            cnt++;
    }
    for (int i = building + 1; i <= N; ++i) {
        double incline;
        double a = (map[i] - map[building]);
        double b = (i - building);
        incline = a / b;
        bool see = true;
        for (int j = building + 1; j <= i - 1; ++j) {
            if ((map[building] + (incline * (j - building))) <= map[j]) {
                see = false;
                break;
            }
        }
        if (see)
            cnt++;
    }
    return cnt;
}
int main() {
    //int t; cin >> t;
    init();
    solve();
}
