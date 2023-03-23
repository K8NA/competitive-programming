// java solution was too slow
// BIT with single update + range query

#include <bits/stdc++.h>
#include <iostream>
#include <utility>
using namespace std;

int getSum(int BITree[], int index) {
  int sum = 0;
  while (index>0) {
    sum += BITree[index];
    index -= index & (-index);
  }
  return sum;
}

void updateBIT(int BITree[], int n, int index, int val) {
  while (index <= n) {
    BITree[index] += val;
    index += index & (-index);
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int t;
  cin >> t;
  for (int i=0; i<t; i++) {
    int n, m, k;
    cin >> n >> m >> k;
    pair<int, int> highways[k];

    for (int j=0; j<k; j++) {
      cin >> highways[j].first;
      cin >> highways[j].second;
    }

    sort(highways, highways+k);

    int bitree[2001] = {};
    long count = 0; // crossings
    int city;

    for (int j=0; j<k; j++) {
      city = highways[j].second;
      if (city != m)
        count += getSum(bitree, m) - getSum(bitree, city);
      updateBIT(bitree, m, city, 1);
    }

    cout << "Test case " << i+1 << ": " << count << "\n";

  }
}
