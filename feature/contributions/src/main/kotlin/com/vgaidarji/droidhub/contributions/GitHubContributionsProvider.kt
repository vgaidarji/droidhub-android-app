package com.vgaidarji.droidhub.contributions

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributions
import kotlinx.serialization.json.Json

class GitHubContributionsProvider : PreviewParameterProvider<GitHubUserContributions> {
    override val values: Sequence<GitHubUserContributions>
        get() {
            val gitHubContributions: GitHubUserContributions = Json.decodeFromString<GitHubUserContributions>(CONTRIBUTIONS_JSON)
            return sequenceOf(gitHubContributions)
        }
}

private val CONTRIBUTIONS_JSON = """
    {
              "totalContributions": 308,
              "weeks": [
                {
                  "contributionDays": [
                    {
                      "weekday": 3,
                      "date": "2020-01-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-01-02T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-01-03T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-01-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-01-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-01-06T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-01-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-01-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-01-09T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-01-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-01-11T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-01-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-01-13T00:00:00.000+00:00",
                      "contributionCount": 19,
                      "color": "#216e39"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-01-14T00:00:00.000+00:00",
                      "contributionCount": 6,
                      "color": "#40c463"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-01-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-01-16T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-01-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-01-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-01-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-01-20T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-01-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-01-22T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-01-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-01-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-01-25T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-01-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-01-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-01-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-01-29T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-01-30T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-01-31T00:00:00.000+00:00",
                      "contributionCount": 4,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-02-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-02-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-02-03T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-02-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-02-05T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-02-06T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-02-07T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-02-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-02-09T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-02-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-02-11T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-02-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-02-13T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-02-14T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-02-15T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-02-16T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-02-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-02-18T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-02-19T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-02-20T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-02-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-02-22T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-02-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-02-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-02-25T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-02-26T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-02-27T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-02-28T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-02-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-03-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-03-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-03-03T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-03-04T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-03-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-03-06T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-03-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-03-08T00:00:00.000+00:00",
                      "contributionCount": 4,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-03-09T00:00:00.000+00:00",
                      "contributionCount": 4,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-03-10T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-03-11T00:00:00.000+00:00",
                      "contributionCount": 6,
                      "color": "#40c463"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-03-12T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-03-13T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-03-14T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-03-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-03-16T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-03-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-03-18T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-03-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-03-20T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-03-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-03-22T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-03-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-03-24T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-03-25T00:00:00.000+00:00",
                      "contributionCount": 4,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-03-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-03-27T00:00:00.000+00:00",
                      "contributionCount": 6,
                      "color": "#40c463"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-03-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-03-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-03-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-03-31T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-04-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-04-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-04-03T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-04-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-04-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-04-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-04-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-04-08T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-04-09T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-04-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-04-11T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-04-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-04-13T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-04-14T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-04-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-04-16T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-04-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-04-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-04-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-04-20T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-04-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-04-22T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-04-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-04-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-04-25T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-04-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-04-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-04-28T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-04-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-04-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-05-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-05-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-05-03T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-05-04T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-05-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-05-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-05-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-05-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-05-09T00:00:00.000+00:00",
                      "contributionCount": 4,
                      "color": "#9be9a8"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-05-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-05-11T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-05-12T00:00:00.000+00:00",
                      "contributionCount": 17,
                      "color": "#216e39"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-05-13T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-05-14T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-05-15T00:00:00.000+00:00",
                      "contributionCount": 5,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-05-16T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-05-17T00:00:00.000+00:00",
                      "contributionCount": 13,
                      "color": "#30a14e"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-05-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-05-19T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-05-20T00:00:00.000+00:00",
                      "contributionCount": 5,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-05-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-05-22T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-05-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-05-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-05-25T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-05-26T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-05-27T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-05-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-05-29T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-05-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-05-31T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-06-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-06-02T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-06-03T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-06-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-06-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-06-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-06-07T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-06-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-06-09T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-06-10T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-06-11T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-06-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-06-13T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-06-14T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-06-15T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-06-16T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-06-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-06-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-06-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-06-20T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-06-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-06-22T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-06-23T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-06-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-06-25T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-06-26T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-06-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-06-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-06-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-06-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-07-01T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-07-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-07-03T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-07-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-07-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-07-06T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-07-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-07-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-07-09T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-07-10T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-07-11T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-07-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-07-13T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-07-14T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-07-15T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-07-16T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-07-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-07-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-07-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-07-20T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-07-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-07-22T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-07-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-07-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-07-25T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-07-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-07-27T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-07-28T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-07-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-07-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-07-31T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-08-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-08-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-08-03T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-08-04T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-08-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-08-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-08-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-08-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-08-09T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-08-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-08-11T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-08-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-08-13T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-08-14T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-08-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-08-16T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-08-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-08-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-08-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-08-20T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-08-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-08-22T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-08-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-08-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-08-25T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-08-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-08-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-08-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-08-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-08-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-08-31T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-09-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-09-02T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-09-03T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-09-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-09-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-09-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-09-07T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-09-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-09-09T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-09-10T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-09-11T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-09-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-09-13T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-09-14T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-09-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-09-16T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-09-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-09-18T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-09-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-09-20T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-09-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-09-22T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-09-23T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-09-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-09-25T00:00:00.000+00:00",
                      "contributionCount": 5,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-09-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-09-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-09-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-09-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-09-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-10-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-10-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-10-03T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-10-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-10-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-10-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-10-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-10-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-10-09T00:00:00.000+00:00",
                      "contributionCount": 4,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-10-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-10-11T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-10-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-10-13T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-10-14T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-10-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-10-16T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-10-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-10-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-10-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-10-20T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-10-21T00:00:00.000+00:00",
                      "contributionCount": 20,
                      "color": "#216e39"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-10-22T00:00:00.000+00:00",
                      "contributionCount": 5,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-10-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-10-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-10-25T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-10-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-10-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-10-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-10-29T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-10-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-10-31T00:00:00.000+00:00",
                      "contributionCount": 20,
                      "color": "#216e39"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-11-01T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-11-02T00:00:00.000+00:00",
                      "contributionCount": 3,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-11-03T00:00:00.000+00:00",
                      "contributionCount": 6,
                      "color": "#40c463"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-11-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-11-05T00:00:00.000+00:00",
                      "contributionCount": 9,
                      "color": "#40c463"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-11-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-11-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-11-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-11-09T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-11-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-11-11T00:00:00.000+00:00",
                      "contributionCount": 11,
                      "color": "#30a14e"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-11-12T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-11-13T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-11-14T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-11-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-11-16T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-11-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-11-18T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-11-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-11-20T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-11-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-11-22T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-11-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-11-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-11-25T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-11-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-11-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-11-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-11-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-11-30T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-12-01T00:00:00.000+00:00",
                      "contributionCount": 2,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-12-02T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-12-03T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-12-04T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-12-05T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-12-06T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-12-07T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-12-08T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-12-09T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-12-10T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-12-11T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-12-12T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-12-13T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-12-14T00:00:00.000+00:00",
                      "contributionCount": 1,
                      "color": "#9be9a8"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-12-15T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-12-16T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-12-17T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-12-18T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-12-19T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-12-20T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-12-21T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-12-22T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-12-23T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-12-24T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 5,
                      "date": "2020-12-25T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 6,
                      "date": "2020-12-26T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                },
                {
                  "contributionDays": [
                    {
                      "weekday": 0,
                      "date": "2020-12-27T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 1,
                      "date": "2020-12-28T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 2,
                      "date": "2020-12-29T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 3,
                      "date": "2020-12-30T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    },
                    {
                      "weekday": 4,
                      "date": "2020-12-31T00:00:00.000+00:00",
                      "contributionCount": 0,
                      "color": "#ebedf0"
                    }
                  ]
                }
              ],
              "months": [
                {
                  "name": "Jan",
                  "year": 2020,
                  "firstDay": "2020-01-01",
                  "totalWeeks": 5
                },
                {
                  "name": "Feb",
                  "year": 2020,
                  "firstDay": "2020-02-01",
                  "totalWeeks": 4
                },
                {
                  "name": "Mar",
                  "year": 2020,
                  "firstDay": "2020-03-01",
                  "totalWeeks": 5
                },
                {
                  "name": "Apr",
                  "year": 2020,
                  "firstDay": "2020-04-01",
                  "totalWeeks": 4
                },
                {
                  "name": "May",
                  "year": 2020,
                  "firstDay": "2020-05-01",
                  "totalWeeks": 5
                },
                {
                  "name": "Jun",
                  "year": 2020,
                  "firstDay": "2020-06-01",
                  "totalWeeks": 4
                },
                {
                  "name": "Jul",
                  "year": 2020,
                  "firstDay": "2020-07-01",
                  "totalWeeks": 4
                },
                {
                  "name": "Aug",
                  "year": 2020,
                  "firstDay": "2020-08-01",
                  "totalWeeks": 5
                },
                {
                  "name": "Sep",
                  "year": 2020,
                  "firstDay": "2020-09-01",
                  "totalWeeks": 4
                },
                {
                  "name": "Oct",
                  "year": 2020,
                  "firstDay": "2020-10-01",
                  "totalWeeks": 4
                },
                {
                  "name": "Nov",
                  "year": 2020,
                  "firstDay": "2020-11-01",
                  "totalWeeks": 5
                },
                {
                  "name": "Dec",
                  "year": 2020,
                  "firstDay": "2020-12-01",
                  "totalWeeks": 4
                }
              ]
    }
""".trimIndent()