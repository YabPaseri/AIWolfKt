# AIWolfKt
## 目的

AIWolfKtでは、人狼知能にKotlinで参加することを目的として、公式ライブラリである`aiwolf-client.jar`と`aiwolf-common.jar`の一部をKotlinようにラップしたクラスが入っているものです。個人的に使用する予定のものを公開しています。



## 使い方

公式ライブラリの`aiwolf-client.jar`と`aiwolf-common.jar`に加えて、このライブラリを追加する。



## 各ファイル

### `tk.yabpaseri.aiwolfkt.common.PlayerKt`

`org.aiwolf.common.data.Player`を実装したabstract classです。プラットフォーム型をNullable or NonNull にするために存在します。Kotlinでは、この`PlayerKt`を継承してPlayerを作成していきます。GameInfoが後述するGameInfoKtになってupdateやinitializeに渡ってきます。



### `tk.yabpaseri.aiwolfkt.common.GameInfoKt`

`org.aiwolf.common.net.GameInfo`を受け取り、保持するクラスです。プラットフォーム型をNullable or NonNullにするために存在します。`PlayerKt`が`GameInfo`を`GameInfoKt`に変換するので、`PlayerKt`を継承したエージェントは、この`GameInfoKt`から情報を得ます。変数名などは、GameInfoに準拠しています。



### `tk.yabpaseri.aiwolfkt.sample.lib.AbstractRoleAssignPlayerKt`

`org.aiwolf.sample.lib.AbstractRoleAssignPlayer`が扱うPlayerをPlayerKtに置き換えたものです。初期設定として、`org.aiwolf.sample.player`の各プレイヤが動く点も同じです。



### `tk.yabpaseri.aiwolfkt.sample.lib.PlayerKtConverter`

PlayerをPlayerKtとして動かすためのクラスです。`AbstractRoleAssignPlayerKt`がサンプルエージェントを動かすためにも使用しています。Playerを実装したクラスを受け取り、そのインスタンスを生成して動かします。



## 生成環境

MacBook Air (Early 2015) 1.6GHz デュアルコアIntel Core i5
macOS Big Sur 11.1

IntelliJ IDEA CE 2020.3.3
Kotlin Plugin 203-1.4.32-release-IJ7148.5



## その他

Twitter: [@YabPaseri](https://twitter.com/YabPaseri) (https://twitter.com/YabPaseri)