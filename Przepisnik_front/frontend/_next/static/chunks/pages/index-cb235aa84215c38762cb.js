(self.webpackChunk_N_E = self.webpackChunk_N_E || []).push([
  [405],
  {
    2777: function (n, i, e) {
      "use strict";
      e.r(i);
      var r = e(7294),
        t = e(5893),
        s = function () {
          var n = (0, r.useState)(),
            i = n[0],
            e = n[1],
            s = (0, r.useState)(),
            c = s[0],
            u = s[1],
            h = (0, r.useState)([]),
            d = h[0],
            o = h[1];
          return (
            (function () {
              if (d.length > 0) return 1;
              fetch(process.env.BACK_URL)
                .then(function (n) {
                  return n.json();
                })
                .then(function (n) {
                  return n.map(function (n, i) {
                    return (0, t.jsx)(
                      "li",
                      {
                        onClick: function () {
                          return (function (n) {
                            fetch(process.env.BACK_URL + n)
                              .then(function (n) {
                                return n.json();
                              })
                              .then(function (n) {
                                u(function () {
                                  return n[0];
                                }),
                                  e(function () {
                                    return n[1];
                                  });
                              });
                          })(i + 1);
                        },
                        children: n,
                      },
                      Math.random()
                    );
                  });
                })
                .then(function (n) {
                  return o(n);
                });
            })(),
            (0, t.jsxs)("div", {
              className: "container",
              children: [
                (0, t.jsx)("header", {
                  children: (0, t.jsx)("h1", {
                    children: "Alicja Szada - Przepi\u015bnik",
                  }),
                }),
                (0, t.jsxs)("div", {
                  id: "przepisy",
                  children: [
                    (0, t.jsxs)("div", {
                      id: "listaPrzepisow",
                      children: [
                        (0, t.jsx)("h3", { children: "Lista przepis\xf3w" }),
                        d,
                      ],
                    }),
                    (0, t.jsxs)("div", {
                      id: "listaSkladnikow",
                      children: [
                        (0, t.jsx)("h3", {
                          children: "Lista sk\u0142adnik\xf3w",
                        }),
                        (0, t.jsx)("pre", { children: c }),
                      ],
                    }),
                    (0, t.jsxs)("div", {
                      id: "opisPrzepisu",
                      children: [
                        (0, t.jsx)("h3", { children: "Opis przygotowania" }),
                        (0, t.jsx)("pre", { children: i }),
                      ],
                    }),
                  ],
                }),
              ],
            })
          );
        };
      (s.suppressFirstRenderFlicker = !0), (i.default = s);
    },
    7540: function (n, i, e) {
      (window.__NEXT_P = window.__NEXT_P || []).push([
        "/",
        function () {
          return e(2777);
        },
      ]);
    },
  },
  function (n) {
    n.O(0, [774, 888, 179], function () {
      return (i = 7540), n((n.s = i));
      var i;
    });
    var i = n.O();
    _N_E = i;
  },
]);
