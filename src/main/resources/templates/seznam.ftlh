[#ftl]
[@c.page title="Seznam vizitek"]
     [#list vizitky]
        <div class="seznam">
            <a href="/detail">
                <div class="vizitka">
                    <div class="jmeno">${vizitka.jmeno}</div>
                    <div class="firma">${vizitka.firma}</div>
                    <div class="udaje">
                        <div class="adresa">
                            <div>${vizitka.ulice}</div>
                            <div><span>11000</span> <span>Praha 1</span></div>
                        </div>
                        <div class="kontakty">
                            <div><i class="las la-at"></i> <span>${vizitka.email}</span></div>
                            <div><i class="las la-phone-alt"></i> <span>${vizitka.telefon}</span></div>
                            <div><i class="las la-globe"></i> <span>${vizitka.web}</span></div>
                        </div>
                    </div>
                </div>
            </a>
     [#else]
         <p class="fst-italic">Seznam vizitek je prázdný.</p>
     [/#list]
        <a href="/nova">
            <div class="vizitka vizitka--nova">
                <svg width="100" height="100">
                    <rect width="20" height="100" x="40" y="0" fill="white"/>
                    <rect width="100" height="20" x="0" y="40" fill="white"/>
                </svg>
            </div>
        </a>
    </div>
[/@c.page]
