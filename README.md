# ShutHub

## 開発環境

* Java 11
* Android Studio

## 配信環境

* master にマージすると GitHub Actions で DeployGate が配信される
* v タグを切ることで本番デプロイが行われる
    * タグ作成自体は[Play ストア リリース管理](https://docs.google.com/spreadsheets/d/1B3x4D0A7qDlgQcrBoB0DyVUrpq1NshG91QVaHFr6cA4/edit#gid=1706314276)より行う

## テスト

master にマージされるとテストが走り自動で[ GitHub Pages ](https://bvlion.github.io/ShutHub/index.html)に結果がアップされる

## キー管理
各 build variant、およびリリースファイルは base64 エンコードした状態で Actions secrets に登録している  
debug 以外は不要にし、必要に応じてオーナーが実データを受け渡すこととする
