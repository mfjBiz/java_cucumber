Feature: 自動販売機

  Scenario Outline: 入金可能な日本円を入れた際の入金額確認
    Given 自動販売機がある
    When <money>円を入金
    Then <chargedMoney>円が入金されている
    Examples:
      |money|chargedMoney|
      |100  |100         |
      |200  |200         |

  Scenario: 複数回入金をした際の入金額確認
    Given 自動販売機がある
    When 100円を入金
    And 10円を入金
    Then 110円が入金されている

  Scenario: 使えない日本円を入金した際の入金額確認
    Given 自動販売機がある
    When 以下のお金を入金
      |1|
      |5|
      |2000|
      |5000|
      |10000|
    Then 0円が入金されている

  Scenario Outline: 入金可能な日本円を入れ、ジュースを購入した際のお釣りの確認
    Given 自動販売機がある
    When <money>円を入金
    And <price>円のジュースを購入する
    Then <change>円のお釣りが返却される
    Examples:
      |money |price|change|
      |1000  |120  |880   |
      |1000  |150  |850   |

  Scenario: お釣りを返却すると残金が0になる
    Given 自動販売機がある
    When 1000円を入金
    And お釣りを返却する
    Then 0円が入金されている

  Scenario Outline: 飲み物ごとの在庫を取得確認
    Given 自動販売機がある
    When <drinkName>を<amount>つ補充する
    Then <drinkName>が<amount>つ在庫にある
    Examples:
      | drinkName | amount |
      | coke      | 3      |
      | coffee    | 5      |

