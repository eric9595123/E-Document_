# CalculatorWSApplication
藍燈系統(工業用)

組裝/包裝線別:
給予資料庫data，去trigger處理資料的action，並顯示資料庫處理的資料。

測試線別:
處理現有XML資訊(WebService)顯示給前端觀察狀態，並於指定時段作儲存。

製程數字燈:
計算預估排站人數，若工時 * 工單數量 < 240 min, Action 人數 = 1
其他狀況 (組裝CT + 測試工時) / max (組裝CT, 測試工時 / 人數)，估算接近平衡率近80%的適應人數(上下班時間尚未考慮在其中)

Cell藍燈:
取現成時間資訊，計算與目標的差距，超過差異正負20%以外進行亮燈，計算訊號藍燈頻率

彈性開線:
讓站別可以隨意由使用者設定作變動 (判斷第幾站開始 & 站數 & 開始比較)

給予訊號:
將處理完的資料以1亮燈、0熄滅的訊號傳送給資料庫，再由其他程式去做讀取(其他程式並不包還在此repo)
