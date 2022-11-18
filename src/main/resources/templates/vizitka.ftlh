[#ftl]
[@c.page title="${vizitka.jmeno!}"]
    [@form.form method="post"]
    <div class="detail">
        <div class="vizitka">
            <div class="jmeno">
                [@form.input name="jmeno" maxlength="100" required="required" /]
            </div>
            <div class="firma">
                [@form.input name="firma" maxlength="100" required="required" /]
            </div>
            <div class="udaje">
                <div class="adresa">
                    <div>
                        [@form.input name="ulice" maxlength="200" required="required" /]
                    </div>
                    <div><span>11000</span> <span>Praha 1</span></div>
                </div>
                <div class="kontakty">
                    <div><i class="las la-at"></i> <span>
                         [@form.input name="email" type="email" /]
                            </span></div>
                    <div><i class="las la-phone-alt"></i> <span>
                            [@form.input name="telefon" type="tel" minlength="9" maxlength="13"/]
                        </span></div>
                    <div><i class="las la-globe"></i> <span>
                            [@form.input name="web" maxlength="200" /]
                        </span></div>
                </div>
            </div>
        </div>

        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=Václavské náměstí 837/11, Praha" width="100%" height="100%" frameborder="0"></iframe>
        </div>

    </div>
    [/@form.form]
[/@c.page]
