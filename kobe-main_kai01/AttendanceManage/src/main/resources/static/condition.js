// 名前がクリックされた時に連絡先を表示する処理
document.querySelectorAll('.clickable').forEach(function(item) {
    item.addEventListener('click', function(event) {
        event.preventDefault(); // デフォルトのリンク動作を無効にする

        // データ属性から電話番号とメールを取得
        const phone = this.getAttribute('data-phone');
        const mail = this.getAttribute('data-mail');
        
        // 連絡先情報を表示するエリアを取得
        const contactInfoDiv = document.getElementById('contactInfo');
        
        // 表示内容を設定
        contactInfoDiv.innerHTML = `<p>電話番号: ${phone}</p><p>メール: ${mail}</p>`;
    });
});
